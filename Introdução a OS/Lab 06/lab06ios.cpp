#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main()
{
	int iOpcao;
	char cParametro1[20] = "lab06ios.cpp";
	char cParametro2[20] = "lab06ios.old";
	char cParametro3[20] = "lab06ios.new";

	do
	{
		printf("\n\n\t * * Lab0601 * * \n");
		
		printf("\n\t 1 - listar ");
		printf("\n\t 2 - copiar ");
		printf("\n\t 3 - mover  ");
		printf("\n\t 9 - Finalizar");
		printf("\n\n\tDigite sua opcao ");
		
		scanf("%d", &iOpcao);

		switch (iOpcao)
		{
		case 1:
			if ( fork()==0 ) execl("/bin/ls", "ls", cParametro1, (char *)NULL);
			break;

		case 2:
			if ( fork()==0 ) execl("/bin/cp", "cp", cParametro1, cParametro3, (char *)NULL);
			break;

		case 3:
			if ( fork()==0 ) execl("/bin/mv", "mv", cParametro3, cParametro2, (char *)NULL);
			break;

		case 9:
			return 0;
			break;

		default:
			printf("\n\n\tOpcao invalida ");
		}

	} while (iOpcao != 9);

	return 0;
}