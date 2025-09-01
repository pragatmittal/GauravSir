#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

// Function prototypes
void resize_array(int size);
void enqueue(int item);
int dequeue();
int size();
bool isEmpty();
void testQueue();

int* array = NULL;
int front = 0;
int rear = 0;
int max_size = 1;

void resize_array(int size) {
    int* new_array = (int*)malloc(size * sizeof(int));

    for (int i = 0; i < rear - front; i++) {
        new_array[i] = array[front + i];
    } // old array me jitne elements hain, unhe naya array me copy karliya
    
    free(array); // purana array ko free kar diya
    array = new_array; // naya array ko global pointer me assign kar diya
    rear -= front;  // rear ko front se adjust kar diya
    front = 0; // front ko 0 pe set kar diya, kyunki ab naya array me elements 0 se start honge
}

int size() {
    return rear - front;
}

bool isEmpty() {
    return front == rear;
}

void enqueue(int item) {
    if (rear == 0) { // agar queue khali hai, to naya array allocate karte hain
        resize_array(max_size); // max_size se naya array banate hain
    } else if (rear == max_size) { // agar queue full hai, to array ko double karte hain
        max_size *= 2;
        resize_array(max_size);
    }
    array[rear++] = item; // item ko rear index pe insert karte hain aur rear ko increment karte hain   
}

int dequeue() {
    if (isEmpty()) return -1; // agar queue khali hai, to -1 return karte hain

    int item = array[front++]; // front se item ko nikaalte hain aur front ko increment karte hain
    
    if (size() > 0 && size() == max_size / 4) { // agar queue me elements hain aur size quarter se kam hai, to array ko half karte hain
        max_size /= 2;
        resize_array(max_size);  // array ko half karte hain
    }
    
    return item;
}

void testQueue() {
    enqueue(3);
    enqueue(10);
    enqueue(12);
    
    assert(isEmpty() == false);
    assert(size() == 3);
    assert(dequeue() == 3);
    assert(size() == 2);
    assert(dequeue() == 10);
    assert(dequeue() == 12);
    assert(isEmpty() == true);
    assert(size() == 0);
}

int main() {
    testQueue();
    printf("All tests passed.\n");
    return 0;
}