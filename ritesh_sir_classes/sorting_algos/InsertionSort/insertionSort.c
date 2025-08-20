// Copyright 2025, Rutansh Chawla.
// This code sorts an arrat in O(n2) time and O(1) space.

#include <stdio.h>

void swap(int *a, int *b) {
  int temp = *a;
  *a = *b;
  *b = temp;
  return;
}

void insertionSort(int *nums, int n) {
  for (int i = 0; i < n; i++) {
    for (int j = i; j > 0; j--) {
      if (nums[j] < nums[j - 1]) {
        swap(&nums[j], &nums[j - 1]);
      }
    }
  }
  return;
}

int main() {
  int nums[] = {5, 4, 3, 2, 1};
  int n = sizeof(nums) / sizeof(int);

  insertionSort(nums, n);

  for (int i = 0; i < n; i++) {
    printf("%d ", nums[i]);
  }

  printf("\n");
}
