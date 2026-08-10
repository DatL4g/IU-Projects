def main():
    print(kgV(15, 20))
    print(kgV(144, 89))

def kgV(a: int, b: int) -> int:
    if a == 0 or b == 0:
        return 0

    return a * b // ggT(a, b)

def ggT(a: int, b: int) -> int:
    while b > 0:
        rest = a % b
        a = b
        b = rest
    return a

if __name__ == "__main__":
    main()