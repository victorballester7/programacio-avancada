#include <stdio.h>
#include <stdlib.h>

int **zeros(int rows, int cols) {
  int **M = malloc(rows * sizeof(int *));
  for (int i = 0; i < rows; i++) {
    M[i] = malloc(cols * sizeof(int));
    for (int j = 0; j < cols; j++)
      M[i][j] = 0;
  }
  return M;
}

void freeMatrix(int **M, int rows) {
  for (int i = 0; i < rows; i++) {
    free(M[i]);
  }
  free(M);
}

int main() {
  int rows = 5, cols = 4;
  int **M = zeros(rows, cols);
  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++)
      printf("%d ", M[i][j]);
    printf("\n");
  }
  freeMatrix(M, rows);
  return 0;
}