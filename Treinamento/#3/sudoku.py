def is_valid_sudoku(matrix):
    # Check rows
    for i in range(9):
        row = set()
        for j in range(9):
            if matrix[i][j] in row:
                return False
            row.add(matrix[i][j])
    
    # Check columns
    for j in range(9):
        col = set()
        for i in range(9):
            if matrix[i][j] in col:
                return False
            col.add(matrix[i][j])
    
    # Check sub-grids
    for k in range(3):
        for l in range(3):
            subgrid = set()
            for i in range(3*k, 3*k+3):
                for j in range(3*l, 3*l+3):
                    if matrix[i][j] in subgrid:
                        return False
                    subgrid.add(matrix[i][j])
    
    return True

def main():
    shape = int(input())

    for i in range(shape):
        matrix = tuple(tuple(map(int, input().split())) for _ in range(9))
        print('Instancia', i+1)
        print('SIM' if is_valid_sudoku(matrix) else 'NAO')
        print()

main()