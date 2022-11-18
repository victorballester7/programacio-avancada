#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct elementPila {
  int num;
  struct elementPila *seg;
} ElementPila;

void push(ElementPila **top, int num) {
  ElementPila *p = malloc(sizeof(ElementPila));
  p->num = num;
  p->seg = *top;
  *top = p;
}

int pilaBuida(ElementPila **top) {
  if (*top == NULL) return 1;
  return 0;
}

int pop(ElementPila **top) {
  if (*top != NULL) {
    ElementPila *aux = *top;
    *top = aux->seg;
    int num = aux->num;
    free(aux);
    return num;
  }
  return INT_MAX;
}

int main() {
  ElementPila *top = NULL;
  push(&top, 20);
  push(&top, 8);
  push(&top, 2);
  printf("Valor extret: %i\n", pop(&top));
  printf("Valor extret: %i\n", pop(&top));
  printf("Valor extret: %i\n", pop(&top));

  return 0;
}
