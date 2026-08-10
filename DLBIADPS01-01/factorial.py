from memory_profiler import profile

def main():
    print(test_recursive(5))
    print(test_recursive(500))

    print(factorial(5))
    print(factorial(500))

    print(factorial(1000))
    print(factorial_rec(1000))

def factorial_rec(num: int) -> int:
    if num < 0:
        raise ValueError("Fakultät ist für negative Zahlen nicht definiert")

    if num == 0:
        return 1

    return num * factorial_rec(num - 1)

@profile
def test_recursive(n: int) -> int:
    return factorial_rec(n)

@profile
def factorial(num: int) -> int:
    if num < 0:
        raise ValueError("Fakultät ist für negative Zahlen nicht definiert")

    result = 1
    for i in range(1, num + 1):
        result *= i

    return result

if __name__ == "__main__":
    main()