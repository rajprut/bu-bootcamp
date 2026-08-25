#include <stdio.h>

void swap(int *a, int *b);
void broken_swap(int a, int b)

int main()  {
    int num1 = 15;
    int num2 = 150;

    printf("Before swap:  x = %d, y = %d\n", num1, num2); 

    swap(&num1, &num2);

    printf("After swap:  x = %d, y = %d\n", num1, num2); 

    return 0;
}

void swap(int *a, int *b) {
    int val = *a;
    *a = *b;
    *b = val;
}

// This function doesn't swap since we don't change the pointers and 
// thus the changes made in this function act as copies and don't change the original values declared in main
void broken_swap(int a, int b) {
    int val = a;
    a = b;
    b = val;
    printf("After swap:  x = %d, y = %d\n", a, b);
}