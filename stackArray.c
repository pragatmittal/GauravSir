#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include <stdbool.h>

int *array;
int N = 0;
int max_size = 1;

void resize_array(int new_size)
{
    int *new_array = (int *) malloc(sizeof(int)*new_size);
    int *temp = array;

    for(int i = 0; i<N; i++) new_array[i] = array[i];
    array = new_array;
    free(temp);
}

void push(int item)
{
    if(N == 0) array = (int *) malloc(sizeof(int)*max_size);
    if(N == max_size){
        max_size*=2;
        resize_array(max_size);
    }
    array[N++] = item;
}

int pop()
{
    int item = array[--N];
    if(N<=max_size/4){
        max_size = max_size/2;
        resize_array(max_size);
    }
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


int main()
{
    testStack();
    printf("All stack tests passed!\n");
    return 0;
}