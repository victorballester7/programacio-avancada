#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

void f(int *n) {
  *n += 2;
  printf("%d\n", *n);
}

void zeros(int v[], int n) {
  for (int i = 0; i < n; i++)
    v[i] = 0;
}

void print_array(int v[], int n) {
  for (int i = 0; i < n; i++)
    printf("%d ", v[i]);
  printf("\n");
}

void main() {
  int n = 50;
  int v[n];
  print_array(v, n);
  zeros(v, n);
  print_array(v, n);
  f(&n);
  printf("%d\n", n);
}
