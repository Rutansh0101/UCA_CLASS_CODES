#include <stdio.h>
#include <stdlib.h>

// Defining node structure
struct Node {
    int data;
    struct Node* next;
};

struct Node* top = NULL;

// Push
void push(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = top;
    top = newNode;
}

// Pop
int pop() {
    if (top == NULL) {
        return -1;
    } else {
        int popped = top->data;
        struct Node* temp = top;
        top = top->next;
        free(temp);
        return popped;
    }
}

// Peek
int peek() {
    if (top == NULL) {
        return -1;
    } else
        return top->data;
}

// Check if empty
int isEmpty() {
    return top == NULL;
}

int main() {
    push(100);
    push(200);
    push(300);

    printf("%d\n", peek());

    printf("%d\n", pop());
    printf("%d\n", peek());

    return 0;
}
