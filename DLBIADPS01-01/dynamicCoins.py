def main():
    available_coins = [1, 3, 4]
    target_value = 6
    result = dynamic(target_value, available_coins)
    print(f"Benötigte Anzahl an Münzen ({available_coins}) für {target_value} ist: {result}")


def dynamic(value: int, coins: list[int]) -> int:
    table = [float("inf")] * (value + 1)
    table[0] = 0

    for current in range(1, value + 1):
        for coin in coins:
            if coin <= current:
                table[current] = min(
                    table[current],
                    table[current - coin] + 1
                )

    return table[value]

if __name__ == "__main__":
    main()