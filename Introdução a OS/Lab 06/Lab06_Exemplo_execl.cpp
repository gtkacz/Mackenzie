#include <stdio.h>
#include <unistd.h>

int main()
{
      execl("/bin/ls","ls","test_exec.c",NULL) ;
      printf ("Eu ainda nao estou morto\n") ;
      exit(0);
}