
launch <- read.csv("challenger.csv")

# estimate beta manually
b <- cov(launch$temperature, launch$distress_ct) / var(launch$temperature)
b

a <- mean(launch$distress_ct) - b * mean(launch$temperature)
a

r <- cov(launch$temperature, launch$distress_ct) /
       (sd(launch$temperature) * sd(launch$distress_ct))
r
cor(launch$temperature, launch$distress_ct)
