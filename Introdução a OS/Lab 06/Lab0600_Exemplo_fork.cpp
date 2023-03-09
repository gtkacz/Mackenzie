#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>


int main ()
{
 pid_t filho;

 int i, status;
 printf ("\n\n *** Inicio Atividade ***  ");
 printf ("\n\nPID         pai   = %d ", getpid());
 printf ("\n\nPPID pai do pai   = %d ", getppid());

 filho = fork(); //aqui criamos o processo filho
 
 if ( filho == 0 ) { //execucao do filho
    printf ("\n Sou o filho executando...\n");
    printf ("\n\nPID         filho = %d  ", getpid());
    printf ("\n\nPPID pai do filho = %d  ", getppid());
    }  // if 
 else { //execucao do filho
    printf ("\n Sou o Pai  executando...\n");
    printf ("\n\nPID         pai   = %d  i ", getpid());
    printf ("\n\nPPID pai do pai   = %d  i ", getppid());
    }  // if 


 printf ("\n\n *** Fim Atividade *** \n\n", getpid());

 return 0;

} // main