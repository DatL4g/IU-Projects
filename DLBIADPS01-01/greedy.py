def main():
    available_coins = [1, 2, 5, 10, 20, 50, 100, 200] # in Cent
    target_value = 987 # 9,87 Euro
    result = greedy(target_value, available_coins)

    print(f"Für {target_value / 100}€ brauchst du diese Münzen:")
    print(result)

def greedy(value: int, coins: list[int]) -> list[int]:
    coins_sorted = sorted(coins, reverse=True)
    required_coins = []

    for coin in coins_sorted:
        while value >= coin:
            required_coins.append(coin)
            value -= coin

    return required_coins

if __name__ == "__main__":
    main()