#include <stdio.h>
#include <unistd.h>

int main()
{
     if ( fork()==0 ) execl( "/bin/ls","ls","test_exec.c",NULL) ;
     else {
          sleep(2) ;  /* espera o fim de ls para executar o printf() */
          printf ("Eu sou o pai e finalmente posso continuar\n") ;
     }
     exit(0);
}