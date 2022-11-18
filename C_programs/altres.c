
#include <stdio.h>

// comment only one of the following two lines
#define WIN
#define LINUX

int main() {
  int a = 4, b = 5;
  int x = (b > a) ? 0 : 1;
  // equivalent to:
  // if (b > a)
  //   x = 0;
  // else
  //   x = 1;

#ifdef WIN  // if WIN is define
  printf("%d\n", x);
#else
  printf("%d\n", x);
#endif
  return 0;
}
