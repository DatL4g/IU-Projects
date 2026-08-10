def main():
    list_sorted = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    list_unsorted = [1, 2, 5, 4, 8]

    print(f"{list_sorted} sorted: {is_sorted(list_sorted)}")
    print(f"{list_unsorted} sorted: {is_sorted(list_unsorted)}")

def is_sorted(num_list: list[int]) -> bool:
    if len(num_list) <= 1:
        return True

    for i in range(len(num_list) - 1):
        if num_list[i] > num_list[i + 1]:
            return False

    return True

if __name__ == "__main__":
    main()