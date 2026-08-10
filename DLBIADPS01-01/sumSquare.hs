main :: IO ()
main = do
    putStrLn $ show $ sumSquareRec 5
    putStrLn $ show $ sumSquare 5

sumSquareRec :: Integer -> Integer
sumSquareRec 0 = 0
sumSquareRec n = n^2 + sumSquareRec (n - 1)

sumSquare :: Integer -> Integer
sumSquare n = sum [x^2 | x <- [1..n]]