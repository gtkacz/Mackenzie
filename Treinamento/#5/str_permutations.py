from itertools import permutations


def main():
    shape = int(input())

    for _ in range(shape):
        s = input().strip()
        perm = list(set(permutations(s)))
        perm.sort()

        for p in perm:
            print(''.join(p))

        print()


main()
