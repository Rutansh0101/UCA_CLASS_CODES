#include <stdio.h>
#define SIZE 100

int stack[SIZE];
int top = -1;

// Push
void push(int value) {
    if (top >= SIZE - 1)
        return;
    else {
        stack[++top] = value;
    }
}

// Pop
int pop() {
    if (top == -1) {
        return -1;
    }
    return stack[top--];
}

// Peek
int peek() {
    if (top == -1) {
        return -1;
    } else
        return stack[top];
}

// Check if empty
int isEmpty() {
    return top == -1;
}

int main() {
    push(10);
    push(20);
    push(30);
    
    printf("%d\n", peek());

    printf("%d\n", pop());

    printf("%d\n", peek());

    return 0;
}
