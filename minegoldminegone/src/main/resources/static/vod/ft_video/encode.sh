

ffmpeg -i sample01.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "1-XniwCLur%3d.ts" 1-XniwCLur.m3u8
ffmpeg -i sample02.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "2-BNXKzZVL%3d.ts" 2-BNXKzZVL.m3u8
ffmpeg -i sample03.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "3-KzYDxTcP%3d.ts" 3-KzYDxTcP.m3u8
ffmpeg -i sample04.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "4-FEDhjpke%3d.ts" 4-FEDhjpke.m3u8
ffmpeg -i sample05.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "5-yRwWemXV%3d.ts" 5-yRwWemXV.m3u8
ffmpeg -i sample06.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "6-pcDfiJpZ%3d.ts" 6-pcDfiJpZ.m3u8
ffmpeg -i sample07.mp4  -c:v copy -c:a copy -f hls -hls_time 9 -hls_playlist_type vod -hls_segment_filename "7-MGDPUcCw%3d.ts" 7-MGDPUcCw.m3u8

# -an : オーディオ disable
# -ss : 切り取り秒開始
# -t  : 切り取り秒終了
cd ../1-XniwCLur
ffmpeg -i sample01.mp4 -ss 0 -t 10 -vcodec copy -an sample01-cut.mp4
ffmpeg -i sample01-cut.mp4 -s 360x200 1-XniwCLur.gif

cd ../2-BNXKzZVL
ffmpeg -i sample02.mp4 -ss 0 -t 10 -vcodec copy -an sample02-cut.mp4
ffmpeg -i sample02-cut.mp4 -s 360x200 2-BNXKzZVL.gif

cd ../3-KzYDxTcP
ffmpeg -i sample03.mp4 -ss 0 -t 10 -vcodec copy -an sample03-cut.mp4
ffmpeg -i sample03-cut.mp4 -s 360x200 3-KzYDxTcP.gif

cd ../4-FEDhjpke
ffmpeg -i sample04.mp4 -ss 0 -t 10 -vcodec copy -an sample04-cut.mp4
ffmpeg -i sample04-cut.mp4 -s 360x200 4-FEDhjpke.gif

cd ../5-yRwWemXV
ffmpeg -i sample05.mp4 -ss 0 -t 10 -vcodec copy -an sample05-cut.mp4
ffmpeg -i sample05-cut.mp4 -s 360x200 5-yRwWemXV.gif

cd ../6-pcDfiJpZ
ffmpeg -i sample06.mp4 -ss 0 -t 10 -vcodec copy -an sample06-cut.mp4
ffmpeg -i sample06-cut.mp4 -s 360x200 6-pcDfiJpZ.gif

cd ../7-MGDPUcCw
ffmpeg -i sample07.mp4 -ss 0 -t 10 -vcodec copy -an sample07-cut.mp4
ffmpeg -i sample07-cut.mp4 -s 360x200 7-MGDPUcCw.gif