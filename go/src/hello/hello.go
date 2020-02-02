package main

import (
	"fmt"
	"time"
	"math/rand"
)

func main() {
	fmt.Printf("Welcome to the playground!")

	fmt.Printf("The time is", time.Now())

	fmt.Printf("My favorite number is", rand.Intn(10))
}