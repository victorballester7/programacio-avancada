#include <stdio.h>
#include <stdlib.h>

#define N 8

typedef struct node {
  struct node **childs;
  int n_childs;
  char board[N][N];
  double value;
} Node;

void copyBoard(char board1[N][N], char board2[N][N]) {
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      board1[i][j] = board2[i][j];
    }
  }
}

int computeColumn(char board[N][N], int i) {
}

int computeRow(char board[N][N], int i) {
}

int computeNumChild(char board[N][N]) {
}

Node *createNode(Node *father, int child_index, int level) {  // Obs: It seems that is missing a parameter (professor message)
  Node *p = malloc(sizeof(Node));
  copyBoard(p->board, father->board);
  int col = computeColumn(p->board, child_index);
  int row = computeRow(p->board, child_index);
  doPlay(p->board, row, col);
  if (level < 2) {
    p->n_childs = computeNumChild(p->board);
    p->childs = malloc(p->n_childs * sizeof(Node *));
  } else {  // leaf
    p->n_childs = 0;
    p->childs = NULL;
  }
  return p;
}

void create1Level(Node *father, int level) {
  for (int i = 0; i < father->n_childs; i++) {  // Obs: i is the number of the child (in general) not the same as the number of the column to play
    father->childs[i] = createNode(father, i, level);
  }
}

// This function supposes that we have just created a root node and its child array has been also created.
void create_tree(Node *root) {
  create1Level(root, 1);
  for (int i = 1; i < root->n_childs; i++) {
    create1Level(root->childs[i], 2);
  }
}

int main() {
  return 0;
}