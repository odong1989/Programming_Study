 read in data and examine structure
concrete <- read.csv("concrete.csv")
str(concrete)

normalize <- function(x) { 
  return((x - min(x)) / (max(x) - min(x)))
}

concrete_norm <- as.data.frame(lapply(concrete, normalize))

summary(concrete_norm$strength)

summary(concrete$strength)
