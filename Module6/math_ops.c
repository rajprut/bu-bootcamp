#include <stdio.h>

void print_math(int a, int b);

int main()  {
    int num1;
    int num2;


    printf("Welcome! Could you please put in the first number?\n");
    scanf("%d", &num1);

    printf("Great! Now could you please put in the second number?\n");
    scanf("%d", &num2);

    print_math(num1, num2);

    return 0;
}

void print_math(int a, int b) {
    int sum = a + b;
    int product = a * b;

    printf("Sum: %8d\n", sum);
    printf("Product: %8d\n", product);

}
