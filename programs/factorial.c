#include <limits.h>
#include <stdio.h>
#include <time.h>

long unsigned int fact(int n) {
  int fact = 1;
  for (int i = 1; i < n + 1; i++)
    fact *= i;
  return fact;
}

long unsigned int fact_rec(int n) {
  if (n == 1) return 1;
  return n * fact_rec(n - 1);
}

int main() {
  int n;
  printf("Enter value: ");
  scanf("%d", &n);
  time_t start1, end1, end2;
  time(&start1);
  printf("Factorial de %i: %lu\n", n, fact(n));
  time(&end1);
  printf("Factorial de %i: %lu\n", n, fact_rec(n));
  time(&end2);
  printf("Time taken 1: %lf\n", (double)start1 - end1);
  printf("Time taken 1: %lf\n", (double)end1 - end2);

  return 0;
}
