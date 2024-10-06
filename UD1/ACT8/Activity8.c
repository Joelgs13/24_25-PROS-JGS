#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main()
{
    int fd1[2], fd2[2];
    char buffer[30];
    
    //i used 4 pids because i had a problem with 2
    pid_t pid, pid1_1, pid_2, pid2_2;
    //the 4 messages to send

    char saludoAbuelo[] = "Saludo del abuelo";
    char saludoPadre[] = "Saludo de padre";
    char saludoHijo[] = "Saludo del hijo";
    char saludoNieto[] = "Saludo del nieto";
    //the pipes to be used
    pipe(fd1);
    pipe(fd2);
    pid = fork();
    if (pid == -1)
    {
        //if anything goes wrong, enters here
        printf("No se ha podido crear el proceso padre...\n");
        exit(-1);
    }
    if (pid == 0)
    {
        //on the child
        pid_2 = fork();
        switch (pid_2)
        {
        case -1:
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
            break;
        case 0:
        //on the last child, we create a message and read the sended one by the father
            close(fd2[1]);
            read(fd2[0], buffer, sizeof(buffer));

            printf("\t\tEl NIETO recibe mensaje del padre: %s\n", buffer);
            printf("\t\tEl NIETO manda un mensaje al HIJO......\n");
            close(fd1[0]);
            write(fd1[1], saludoNieto, sizeof(saludoNieto));

            //writes and then exits.
            exit(0);
            break;
        default:
            close(fd1[1]);
            //reads the message of the grandfather
            read(fd1[0], buffer, sizeof(buffer));

            printf("\tEl HIJO recibe un mensaje de abuelo: %s\n", buffer);
            //sends a message to the child
            printf("\tEl HIJO envia un mensaje al NIETO......\n");
            close(fd2[0]);

            write(fd2[1], saludoPadre, sizeof(saludoPadre));
            pid2_2 = wait(NULL); //waits for the child
            close(fd1[1]);
            read(fd1[0], buffer, sizeof(buffer));
            //reads the message of the grandfather and sends otherone to the child
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
        write(fd1[1], saludoAbuelo, sizeof(saludoAbuelo)); //sends a message for the father

        pid1_1 = wait(NULL); //waits for the father
        close(fd2[1]);
        read(fd2[0], buffer, sizeof(buffer));
        //reads the message of the father
        printf("El ABUELO recibe un mensaje del HIJO: %s\n", buffer);
    }
}