#include <stdio.h>


void swap(int *a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
	return;
}


void selectionSort(int *nums, int n){

	for(int i = 0; i < n; i++){
		int min = i;

		for(int j = i; j < n; j++){
			if(nums[min] > nums[j]){
				min = j;
			}
		}

		swap(&nums[min], &nums[i]);
	}

	return;

}


int main(){
	int nums[] = {5, 4, 3, 2, 1};
	int n = sizeof(nums) / sizeof(int);

	selectionSort(nums, n);

	for(int i = 0; i < n; i++){
		printf("%d ", nums[i]);
	}

	printf("\n");
}
