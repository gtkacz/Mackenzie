from collections import Counter


def sort_key(char_freq):
    char, freq = char_freq
    return (freq, -ord(char))


def main():
    init = True

    while True:
        try:
            line = input().strip()

            if init:
                init = False

            else:
                print()

            char_freqs = Counter(line)

            sorted_chars = sorted(char_freqs.items(), key=sort_key)
            for char, freq in sorted_chars:
                print(ord(char), freq)

        except EOFError:
            break


main()
