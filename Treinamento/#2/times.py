def main():
    student_qty, team_qty = map(int, input().split())

    students = sorted([input().split() for i in range(student_qty)], key=lambda item: int(item[1]))

    teams = [[] for i in range(team_qty)]

    while len(students) > 0:
        for i in range(team_qty):
            if len(students) == 0:
                break

            teams[i].append(students.pop(-1))

    teams = [sorted(team, key=lambda item: item[0]) for team in teams]

    for index, team in enumerate(teams):
        print(f'Time {index+1}')
        for student in team:
            print(student[0])
        print()

main()