#9-1. 과제 (파일 제출)

library(devtools)
library("ggmap")
register_google(key = #'API 키')

#(1) 서울시청 지역의 지도를 표시하되 지도 크기는 800x600 으로 하고 maptype 은 "roadmap" 으로 하시오.
  addr <- c('서울특별시 중구 명동 세종대로 110')

gc <- geocode(enc2utf8(addr))
gc

df <- data.frame(name = names,
                 lon = gc$lon,
                 lat = gc$lat)


cen <- c(mean(df$lon), mean(df$lat))

cityhall_map <- get_googlemap(center = cen,
                              zoom = 16, 
                              maptype = 'roadmap', 
                              markers = gc)

gmap <- ggmap(cityhall_map )

gmap

#(2) 금강산 지역의 지도를 표시하되 지도 크기는 640x480 으로 하고 maptype 은 "hybrid" 으로 하시오.
#zoom 은 8로 하시오.
  addr <- c('M443+MX Ssukpat, 조선민주주의인민공화국')
gc <- geocode(enc2utf8(addr))
df <- data.frame(name = names,
                 lon = gc$lon,
                 lat = gc$lat)

cen <- c(df$lon, df$lat)


mt.map <- get_googlemap(center = cen,
                        maptype = "hybrid",
                        zoom = 10,
                        markers = gc)

gmap <- ggmap(mt.map)
gmap
  
#(3) 경도 103.867881, 위도 1.331017 지역의 지도를 표시하되 maptype 은 "roadmap" 으로 하고, zoom 은 9로 하시오.
  cen <- c(103.867881, 1.331017)
sgp <- get_googlemap(center = cen,
                     maptype = "roadmap",
                     zoom = 9)

gmap <- ggmap(sgp)
gmap
