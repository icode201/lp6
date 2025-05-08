#include <stdio.h>
#include "mpi.h"
int main(int argc, char* argv[])
{
int rank, size, len;
MPI_Init(&argc, &argv);
MPI_Comm_rank(MPI_COMM_WORLD, &rank);
MPI_Comm_size(MPI_COMM_WORLD, &size);
printf("Hello, world, I am %d of %d\n",rank, size);
MPI_Finalize();
return 0;
}
/*(base) it@it-Vostro-3710:~/Narendra Gores mpicc hello.c 
(base) it@it-Vostro-3710:~/Narendra Gores mpirun -np 4./a.out 
Hello, world, I am 0 of 4 
Hello, world, I am 2 of 4 
Hello, world, I am 1 of 4 
Hello, world, I am 3 of 4 
(base) it@it-Vostro-3710:~/Narendra Gores mpicc world1.c 
(base) it@it-Vostro-3710:-/Narendra Gores mpirun -np 0./a.out 
Distribution at rank 0 
local sum at rank 3 is 90 
local sum at rank 2 is 65 
? 
local sum at rank 1 is 40 
local sum at rank 0 is 15 
final sum = 210 
(base) it@it-Vostro-3710:-/Narendra Gores mpicc world.c ( 
base) it@it-Vostro-3710:~/Narendra Gore$ mpirun -np 0./a.out 
at rank 1 
Sending message containing: 10 from rank 0 
at rank 2 
Received message containing: 10 at rank 1 
at rank 3
*/