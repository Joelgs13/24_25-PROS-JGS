#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main (){
    int fd1[2];
    int fd2[2];
    char buffer[80];
    // the 4 messages to be sent
    char saludoAbuelo[] = "Saludo del abuelo";
    char saludoPadre[] = "Saludo del padre";
    char saludoNieto[] = "Saludo del nieto";
    char saludoHijo[] = "Saludo del hijo";
    
    pid_t pid, pid2;
    
    pipe(fd1);
    pipe(fd2);
    
    pid = fork(); // Fork for hijo
    switch (pid) {
        case -1: // error: can't create child process
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
        case 0: { // hijo receives
            close(fd1[1]); // Close write end of fd1 (for hijo)
            read(fd1[0], buffer, sizeof(buffer)); // hijo reads from fd1
            printf("\tEl hijo recibe el mensaje del abuelo: %s\n", buffer);

            pid2 = fork(); // Fork for nieto
            if (pid2 == -1) {
                printf("\tNo se ha podido crear el proceso nieto...\n");
                exit(-1);
            } else if (pid2 == 0) { // nieto receives
                close(fd2[1]); // Close write end of fd2 (for nieto)
                read(fd2[0], buffer, sizeof(buffer)); // nieto reads from fd2
                printf("\t\tEl Nieto recibe el mensaje del padre: %s\n", buffer);

                close(fd1[0]); // Close read end of fd1 (not used by nieto)
                write(fd1[1], saludoNieto, sizeof(saludoNieto)); // nieto sends message to hijo
                printf("\t\tEl NIETO envía un mensaje al HIJO...\n");
                exit(0);
            } else { // hijo sends
                close(fd2[0]); // Close read end of fd2 (for hijo)
                write(fd2[1], saludoPadre, sizeof(saludoPadre)); // hijo sends message to nieto
                printf("\tEl Hijo envía un mensaje al NIETO...\n");
                
                wait(NULL); // hijo waits for nieto
                
                close(fd1[1]); // Close write end of fd1 (for hijo)
                read(fd1[0], buffer, sizeof(buffer)); // hijo reads from nieto via fd1
                printf("\tEl Hijo recibe el mensaje de su hijo: %s\n", buffer);

                close(fd2[1]); // Close write end of fd2 (for hijo)
                write(fd2[0], saludoHijo, sizeof(saludoHijo)); // hijo sends message to abuelo
                printf("\tEl Hijo envía un mensaje al ABUELO...\n");
            }
            exit(0);
        }
        default: { // abuelo sends
            close(fd1[0]); // Close read end of fd1 (for abuelo)
            write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo)); // abuelo sends message to hijo
            printf("El ABUELO envía un mensaje al Hijo...\n");
            
            wait(NULL); // abuelo waits for hijo
            
            close(fd2[1]); // Close write end of fd2 (for abuelo)
            read(fd2[0], buffer, sizeof(buffer)); // abuelo reads from hijo via fd2
            printf("El ABUELO recibe el mensaje del hijo: %s\n", buffer);
        }
        break;
    }
    exit(0);
}

/*
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
void main()
{
    int fd1[2], fd2[2];
    char buffer[30];
    pid_t pid, pid_2, HIJO_pid, HIJO2_pid;
    char saludoAbuelo[] = "Saludo del abuelo";
    char saludoPadre[] = "Saludo de padre";
    char saludoHijo[] = "Saludo del hijo";
    char saludoNieto[] = "Saludo del nieto";
    pipe(fd1);
    pipe(fd2);
    pid = fork();
    if (pid == -1)
    {
        printf("No se ha podido crear el proceso padre...\n");
        exit(-1);
    }
    if (pid == 0)
    {
        pid_2 = fork();
        switch (pid_2)
        {
        case -1:
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
            break;
        case 0:
            close(fd2[1]);
            read(fd2[0], buffer, sizeof(buffer));
            printf("\t\tEl NIETO recibe mensaje del padre: %s\n", buffer);
            printf("\t\tEl NIETO manda un mensaje al HIJO......\n");
            close(fd1[0]);
            write(fd1[1], saludoNieto, sizeof(saludoNieto));
            exit(0);
            break;
        default:
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            printf("\tEl HIJO recibe un mensaje de abuelo: %s\n", buffer);
            printf("\tEl HIJO envia un mensaje al NIETO......\n");
            close(fd2[0]);
            write(fd2[1], saludoPadre, sizeof(saludoPadre));
            HIJO2_pid = wait(NULL);
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            printf("\tEl HIJO recibe un mensaje de su hijo: %s\n", buffer);
            printf("\tEl HIJO envia un mensaje al ABUELO......\n");
            close(fd2[0]);
            write(fd2[1], saludoHijo, sizeof(saludoHijo));
            break;
        }
    }
    else
    {
        printf("El ABUELO envia un mensaje al HIJO......\n");
        close(fd1[0]);
        write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo));
        HIJO_pid = wait(NULL);
        close(fd2[1]);
        read(fd2[0], buffer, sizeof(buffer));
        printf("El ABUELO recibe un mensaje del HIJO: %s\n", buffer);
    }
}*/
