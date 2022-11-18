
#include <stdio.h>

void laberint(int x, int y, int m[3][3], int compta) {
  if (x >= 0 && x < 3 && y >= 0 && y < 3 && m[y][x] == 0) {
    m[y][x] = 1;
    laberint(x + 1, y, m, compta + 1);  // dreta
    laberint(x - 1, y, m, compta + 1);  // esquerra
    laberint(x, y + 1, m, compta + 1);  // dalt
    laberint(x, y - 1, m, compta + 1);  // avall
    m[y][x] = 0;
  }
  if (y == 3 && x == 2) {  // sortida trobada
    printf("Solució trobada en %d passos.\n", compta);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        printf("%d ", m[i][j]);
      }
      printf("\n");
    }
    printf("-------------\n");
  }
}

int main() {
  int m[3][3] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
  laberint(0, 0, m, 1);
  return 0;
}
