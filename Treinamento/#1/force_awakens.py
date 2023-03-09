def main() -> str:
    row = input().split()
    shape_y = int(row[0])
    shape_x = int(row[1])

    content = []

    for i in range(shape_y):
        current_input = input().split()
        
        current_row = [int(x) for x in current_input]

        content.append(current_row)

    for y in range(1, shape_y-1):
        for x in range(1, shape_x-1):
            if content[y][x] == 42:
                found_upper_left = content[y-1][x-1] == 7
                found_upper_center = content[y-1][x] == 7
                found_upper_right = content[y-1][x+1] == 7

                found_left = content[y][x-1] == 7
                found_right = content[y][x+1] == 7
                
                found_lower_left = content[y+1][x-1] == 7
                found_lower_center = content[y+1][x] == 7
                found_lower_right = content[y+1][x+1] == 7

                if found_upper_left and found_upper_center and found_upper_right and found_left and found_right and found_lower_left and found_lower_center and found_lower_right:
                    return f'{y+1} {x+1}'
                
    return '0 0'

print(main())