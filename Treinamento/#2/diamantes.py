def main():
    shape = int(input())
    mines = tuple(input() for i in range(shape))

    for mine in mines:
        curr_mine = mine.replace('.', '')
        diamonds = 0

        while True:
            if '<>' in curr_mine:
                diamonds += 1
                curr_mine = curr_mine.replace('<>', '', 1)
            else:
                break

        print(diamonds)

main()