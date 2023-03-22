def main():
    while True:
        lines, columns, position = map(int, input().split())
        exploded = False

        if (lines, columns, position) == (0, 0, 0):
            break

        position -= 1

        matrix = []

        for _ in range(lines):
            matrix.append(list(map(int, input().split())))

        for curr_p, row in enumerate(matrix):
            if row[position] > 0:
                print(f'BOOM {curr_p} {position+1}')
                exploded = True
                break

            row[position] = -1

            curr_row = list(filter(lambda i: i != 0, row))

            pos_idx = curr_row.index(-1)

            force = curr_row[pos_idx-1] - curr_row[pos_idx+1]

            position += force
            position = min(position, len(row)-1)


        if not exploded:
            if row[position] > 0:
                print(f'BOOM {curr_p+1} {position+1}')
            else:
                print(f'OUT {position+1}')

        print(matrix)


main()
