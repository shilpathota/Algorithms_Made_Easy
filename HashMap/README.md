# Hash Map

## Hash Map - One of the efficient algorithm that all the programming languages use

Before diving into hash map, I would like to bring in the predecessors of the hash map which is hash table and other data structure which is Hash Set


## Hash Table
### What is Hash Table?
Hash Table is a data structure which organizes data using hash functions in order to support quick insertion and search. 
### What does the hash table do?
- When we insert a new key, the hash function will decide which bucket the key should be assigned and the key will be stored in the corresponding bucket
- When we want to search a key, the hash table will use the same hash function to find the corresponding bucket and search only in the specific bucket.

For Example, we use y = x % 5 as our hash function. 1987 is assigned to bucket 2 while 24 is assigned to bucket 4.
- During the insert, we parse the keys through the hash function to map them into corresponding bucket.
- During the search, we parse the keys through the same hash function and search only in the specific bucket
## Hash function
The hash function is most important component of a hash table which is used to map the key to specific bucket. The hash function will depend on the range of key values and the number of buckets.
Here is the brief of how we design the hash function. The idea is to try to assign the key to the bucket as uniformly as you can. Ideally, a perfect hash function will be a one-one mapping between the key and bucket. However, in most cases, a hash function is not perfect and it is tradeoff between the amount of buckets and the capacity of a bucket.
## Handling Collision
Ideally, if there is one- one mapping, we do not get any collision. but in most cases, collision is almost inevitable which is 2 keys resolve to have the same bucket as shown in above figure.


We should design an algorithm such that  
- It should organize multiple values in same bucket.
- Handle the situation where too many values are assigned to same bucket
- Search for the target value in the specific bucket

This gives other important parameter which is capacity of the bucket and the number of keys which might be mapped into the same bucket according to the hash function
We can store the multiple values in a single array in the bucket if Maximum Number of keys in bucket is small but if it is bigger we go for height balanced binary search tree.
