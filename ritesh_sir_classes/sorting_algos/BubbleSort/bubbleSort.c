// This code sorts an array in O(N2) Time and O(1) space.
// Copyright 2025, Rutansh Chawla

#include <stdio.h>

void bubbleSort(int *nums, int n) {
    for (int i = 0; i < n; i++) {
        int isSwapped = 0;
        for (int j = 0; j < n - i - 1; j++) {
            if (nums[j] > nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                isSwapped  = 1;
            }
        }
         if (isSwapped == 0)    break;
    }
    return;
}

int main() {
    int nums[] = {4, 9, -100, -2, 0, 1, 22, 3, 1};
    int n = sizeof(nums) / sizeof(int);

    bubbleSort(nums, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
    return 0;
}
