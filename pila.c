#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#define N 50

typedef struct pila {
  int v[N], top;
} Pila;

int pilaPlena(Pila *p) {
  if (p->top == N - 1) return 1;
  return 0;
}

int pilaBuida(Pila *p) {
  if (p->top == -1) return 1;
  return 0;
}
void push(Pila *p, int n) {
  if (!pilaPlena(p))
    p->v[++p->top] = n;
}

int pop(Pila *p) {
  if (!pilaBuida(p))
    return p->v[p->top--];
  return INT_MAX;
}

void inicialitzacio(Pila *p) {
  p->top = -1;  // same as (*p).top = -1;
}

int main() {
  int n;
  scanf("%d", &n);

  Pila p1, p2;
  inicialitzacio(&p1);
  inicialitzacio(&p2);
  push(&p1, 3);
  push(&p2, 8);
  push(&p1, -2);
  printf("Valor extret: %i\n", pop(&p2));
  printf("Valor extret: %i\n", pop(&p1));
  printf("Valor extret: %i\n", pop(&p1));
  // push(p, 8);
  // push(p, -2);
  // printf("Valor extret: %i\n", pop(p));
  // printf("Valor extret: %i\n", pop(p));
  // int res = pop(p);
  // if (res == INT_MAX)
  //   printf("Error, la pila és buida.\n");
  // else
  //   printf("Valor extret: %i\n", res);

  return 0;
}
