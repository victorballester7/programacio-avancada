#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
  long t = 2;
  printf("%ld\n", t);
  srand(t);  // only once in all the code
  for (int i = 0; i < 10; i++)
    printf("%lf\n", rand() * 1. / RAND_MAX);  // rand integer between 0 and RAND_MAX (32767)
}