import sys
from collections import deque
from itertools import islice

def main() -> str:
    shape = int(sys.stdin.readline())
    content = deque(map(int, sys.stdin.readline().split()))
    
    is_even = deque(filter(lambda item: item % 2 == 0, content))

    if is_even:
        first_even = content.index(is_even[0])+1
        sheep_before_first = len(list(filter(lambda item: item == 1, islice(content, 0, first_even))))
        return f'{first_even} {sum(content) - ((((first_even-1)*2)+1) - sheep_before_first)}'

    else:
        return f'{shape} {sum(content) - shape}'

print(main())
