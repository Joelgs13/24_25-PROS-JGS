#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/wait.h>

void signalManager(int signal) {
    printf("Padre recibe señal... %d\n", signal);
}

void main() {
    int pid_hijo, pid_1;
    pid_1 = getpid();
    pid_hijo = fork(); // creamos el hijo

    switch (pid_hijo) {
        case -1: // error
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
            break;
        case 0:   // Hijo
            sleep(1); // Wait to ensure the parent sets up the signal handler
            kill(pid_1, SIGUSR1); // Send signal to parent
            sleep(1);
            kill(pid_1, SIGUSR1);
            sleep(1);
            kill(pid_1, SIGUSR1);
            sleep(1);
            kill(pid_1, SIGKILL); 
            break;
        default: // El padre recibe señales
            signal(SIGUSR1, signalManager); // Set up signal handler for SIGUSR1
            
            while (1) {};
            /*// Parent waits for 4 signals
            pause(); // Wait for first signal
            pause(); // Wait for second signal
            pause(); // Wait for third signal
            pause(); // Wait for termination signal*/
            break;
    }

    exit(0);
}
