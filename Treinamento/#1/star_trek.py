def main():
    shape = int(input())

    raw_content = input().split()
        
    content = [int(x) for x in raw_content]

    initial_content = tuple(content)

    def is_even(number):
        return number % 2 == 0
        
    curr_star = 0

    while True:
        try:
            if is_even(content[curr_star]):
                future_star = curr_star-1
            else:
                future_star = curr_star+1

            content[curr_star] -= 1 if (content[curr_star] >= 0) else 0

            curr_star = future_star

            if future_star < 0:
                break
        
        except IndexError:
            break

    star_sum = len([star_index+1 for star_index in range(len(content)) if (content[star_index] != initial_content[star_index])])
    sheep_sum = sum(content)

    return f'{star_sum} {sheep_sum}'


print(main())