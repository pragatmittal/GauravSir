#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <stdbool.h>


struct Node
{
    int item;
    struct Node*next;
};

int N = 0;
struct Node*head = NULL;

void push(int item)
{
    struct Node*oldHead = head;
    head = (struct Node*)malloc(sizeof(struct Node));
    head->item = item;
    N++;
    head->next = oldHead;
}

int pop()
{
    if(N==0) return INT_MIN;
    struct Node* temp = head;
    int item = temp->item;
    head = head->next;
    N--;
    free(temp);
    return item;
}


bool isEmpty()
{   
    return N==0;
}

int size()
{
    return N;
}

void testStack()
{
    push(1);
    push(2);
    push(3);

    assert(pop()==3);
    assert(size()==2);
    assert(isEmpty()==false);

    assert(pop()==2);
    assert(size()==1);
    assert(isEmpty()==false);

    assert(pop()==1);
    assert(size()==0);
    assert(isEmpty()==true);
}

int main(){  
    testStack();
    printf("Test Cases Passed");
    return 0;
}