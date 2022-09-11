#include <stdio.h>
#include <stdlib.h>

int main()
{
    int pid;

    printf("ROOT PID: %d\n", getpid());

    for (int i = 0; i < 3; i++)
    {
        switch (pid = fork())
        {
        case -1:
            fprintf(stderr, "fork() failed");
            return 1;
        case 0:
            printf("CHILD: pid=%d, ppid=%d\n", getpid(), getppid());
            break;
        default:
            printf("PARENT: pid=%d, ppid=%d\n", getpid(), getppid());
            break;
        }
    }

    return 0;
}