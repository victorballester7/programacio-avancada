#include <stdio.h>
#include <stdlib.h>

int *zeros(int n) {
  int *v = malloc(5 * sizeof(int));
  for (int i = 0; i < n; i++)
    v[i] = 0;
  return v;
}

void zeros2(int **v, int n) {
  *v = malloc(5 * sizeof(int));
  for (int i = 0; i < n; i++)
    (*v)[i] = 0;
}

int main() {
  int n = 5;
  int *v = zeros(5);
  int *u;
  zeros2(&u, 5);
  for (int i = 0; i < n; i++)
    printf("%d ", v[i]);
  printf("\n");
  for (int i = 0; i < n; i++)
    printf("%d ", v[i]);
  printf("\n");
  free(v);
  free(u);
  return 0;
}