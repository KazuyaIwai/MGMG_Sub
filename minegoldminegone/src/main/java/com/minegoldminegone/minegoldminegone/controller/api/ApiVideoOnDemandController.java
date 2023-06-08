package com.minegoldminegone.minegoldminegone.controller.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.minegoldminegone.minegoldminegone.dto.FtCommentDto;
import com.minegoldminegone.minegoldminegone.dto.FtIndividualVideoInfoDto;
import com.minegoldminegone.minegoldminegone.dto.FtThumbnailVideoDto;
import com.minegoldminegone.minegoldminegone.dto.FtVIdeoPath;
import com.minegoldminegone.minegoldminegone.dto.FtRecommendVideoDto;
import com.minegoldminegone.minegoldminegone.dto.FtSuggestSearchDto;
import com.minegoldminegone.minegoldminegone.model.FtSubscribedChannel;
import com.minegoldminegone.minegoldminegone.model.FtVideos;
import com.minegoldminegone.minegoldminegone.repository.FtSubscribedChannelRepository;
import com.minegoldminegone.minegoldminegone.repository.FtVideoRepository;
import com.minegoldminegone.minegoldminegone.repository.FtVideoSummaryRepository;
import com.minegoldminegone.minegoldminegone.service.FtVideosService;

@RestController
@RequestMapping("/api/stream")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiVideoOnDemandController {

	@Autowired
	private FtVideosService ftVideosService;
	@Autowired
	private FtVideoRepository ftVideoRepository;
	@Autowired
	private FtVideoSummaryRepository ftVideoSummaryRepository;
	@Autowired
	private FtSubscribedChannelRepository ftSubscribedChannelRepository;
	
	@GetMapping("")
	@ResponseBody
	public List<FtThumbnailVideoDto> home(
			@RequestParam(name = "limit", required = true) int limit,
			@RequestParam(name = "offset", required = true) int offset,
			Model model) {
		List<FtThumbnailVideoDto> list = 
			ftVideosService.fetchFtThumbnailVideoDto(limit, offset);
		return list;
	}

	@GetMapping("channelIcon")
	@ResponseBody
	public ResponseEntity<Resource> channelIcon(
		@RequestParam(name = "channelId", required = true) String channelId, 
			Model model) {
				if ( StringUtils.isEmpty(channelId) ) return ResponseEntity.notFound().build();
				try {
					// videoIdからファイル名を取得
					Optional<FtSubscribedChannel> channel = ftSubscribedChannelRepository.findById(channelId);
					String fileName = "";
					if ( channel.isPresent() ) fileName = channel.get().getChannelIcon();

					// ファイルへのパスを指定します
					Path filePath = Paths.get(
							ftVideosService.getSystemValueByName("CHANNEL_DIR"), channelId, fileName);
					// Resourceオブジェクトを作成します
					Resource resource = new UrlResource(filePath.toUri());
					// ファイルが存在し、読み込めることを確認します
					if (resource.exists() && resource.isReadable()) {
							// レスポンスヘッダーを設定し、ファイルを返します
							return ResponseEntity.ok()
											.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
											.body(resource);
					} else {
							return ResponseEntity.notFound().build();
					}
				} catch (MalformedURLException e) {
						return ResponseEntity.badRequest().build();
				}
	}

	@GetMapping("userIcon")
	@ResponseBody
	public ResponseEntity<Resource> userIcon(
		@RequestParam(name = "userId", required = true) String userId, 
			Model model) {
				if ( StringUtils.isEmpty(userId) ) return ResponseEntity.notFound().build();
				try {
					// ファイルへのパスを指定します
					Path filePath = Paths.get(
							ftVideosService.getSystemValueByName("USER_DIR"), userId + ".png");
					// Resourceオブジェクトを作成します
					Resource resource = new UrlResource(filePath.toUri());
					// ファイルが存在し、読み込めることを確認します
					if (resource.exists() && resource.isReadable()) {
							// レスポンスヘッダーを設定し、ファイルを返します
							return ResponseEntity.ok()
											.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
											.body(resource);
					} else {
							return ResponseEntity.notFound().build();
					}
				} catch (MalformedURLException e) {
						return ResponseEntity.badRequest().build();
				}
	}

	@GetMapping("thumbnail")
	public ResponseEntity<Resource> thumbnailImg(
		@RequestParam(name = "vid", required = true) String vId, 
		@RequestParam(name = "isHover", required = true) boolean isHover, 
		Model model) {

		try {

			FtVideos ftVideo = ftVideoRepository.fetchByVId(vId);
			if (ftVideo == null) throw new MalformedURLException();

			// vIdからファイル名を取得
			String fileName = isHover ? ftVideo.getThumbnailHover() : ftVideo.getThumbnailImage();

			// ファイルへのパスを指定します
			Path filePath = Paths.get(
				ftVideosService.getSystemValueByName("VIDEO_DIR"), ftVideo.getVideoId() + "-" + vId, fileName);
			// Resourceオブジェクトを作成します
			Resource resource = new UrlResource(filePath.toUri());
			// ファイルが存在し、読み込めることを確認します
			if (resource.exists() && resource.isReadable()) {
					// レスポンスヘッダーを設定し、ファイルを返します
					return ResponseEntity.ok()
									.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
									.body(resource);
			} else {
					return ResponseEntity.notFound().build();
			}
		} catch (MalformedURLException e) {
				return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("individual/info")
	@ResponseBody
	public FtIndividualVideoInfoDto individualVideoInfo(
		@RequestParam(name = "vid", required = true) String vid,
		Model model) {
		FtIndividualVideoInfoDto info = ftVideosService.fetchFtIndividualVideoInfoDto(vid);
		return info;
	}


	@GetMapping(value = "/individual/video-path")
	@ResponseBody
	public FtVIdeoPath streamVideo(@RequestParam(name = "vid", required = true) String vid) 
		throws IOException {
			FtVideos ftVideo = ftVideoRepository.fetchByVId(vid);
			if (ftVideo == null) return new FtVIdeoPath(vid, "");
			
			Path filePath = Paths.get(
				ftVideosService.getSystemValueByName("VIDEO_DIR"), 
				ftVideo.getVideoId() + "-" + vid, 
				ftVideo.getVideoLink());
			return new FtVIdeoPath(vid, filePath.toUri().toString());
	}

	@GetMapping(value = "/individual/video", produces = "application/vnd.apple.mpegurl")
	public ResponseEntity<Resource> streamVideoFile(@RequestParam(name = "vid", required = true) String vid) 
	throws IOException {
		FtVideos ftVideo = ftVideoRepository.fetchByVId(vid);
		if (ftVideo == null) return ResponseEntity.notFound().build();
		
		Path filePath = Paths.get(
			ftVideosService.getSystemValueByName("VIDEO_DIR"), 
			ftVideo.getVideoId() + "-" + vid, 
			ftVideo.getVideoLink());
		Resource resource = new UrlResource(filePath.toUri());
		if (resource.exists() && resource.isReadable()) {
				return ResponseEntity.ok()
								.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
								.body(resource);
		} else {
				return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "/individual/{fileName}")
	public ResponseEntity<Resource> streamVideoFileTs(@PathVariable String fileName) 
	throws IOException {
		Pattern pattern = Pattern.compile("\\d+\\.\\w+"); // 数値＋拡張子を表す正規表現パターンを定義します。
		Matcher matcher = pattern.matcher(fileName); // 正規表現パターンをファイル名に適用します。
		String savedDir = fileName;
		if (matcher.find()) { // 数値＋拡張子を含む部分が見つかった場合に処理を行います。
				String match = matcher.group(); // 数値＋拡張子の部分を取得します。
				savedDir = fileName.replace(match, ""); // 取得した部分をファイル名から削除します。
				// 視聴回数用（001までダウンロードされてたら視聴とみなす）
				if (match.startsWith("001")) {
					String[] videoIdVid = savedDir.split("-");
					ftVideoSummaryRepository.updateViewsIncrement(videoIdVid[0]);
				}
		}
		Path filePath = Paths.get(
			ftVideosService.getSystemValueByName("VIDEO_DIR"), savedDir, fileName);
		Resource resource = new UrlResource(filePath.toUri());
		if (resource.exists() && resource.isReadable()) {
				return ResponseEntity.ok()
								.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
								.body(resource);
		} else {
				return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("individual/comment")
	@ResponseBody
	public List<FtCommentDto> ftComment(
		@RequestParam(name = "vid", required = true) String vid, @RequestParam(name = "offset", required = true) Integer offset,
		Model model) {
		List<FtCommentDto> comments = ftVideosService.fetchFtCommentDto(vid, offset);
		return comments;
	}

	@GetMapping("individual/comment/summary")
	@ResponseBody
	public Integer ftCommentSummary(
		@RequestParam(name = "vid", required = true) String vid,
		Model model) {
		Integer sum = ftVideosService.fetchFtCommentSummary(vid);
		return sum;
	}

	@GetMapping("individual/recommend")
	@ResponseBody
	public List<FtRecommendVideoDto> ftRecommend(
		@RequestParam(name = "vid", required = true) String vid, @RequestParam(name = "offset", required = true) Integer offset,
		Model model) {
		List<FtRecommendVideoDto> comments = ftVideosService.fetchFtRecommendVideoDto(vid, offset);
		return comments;
	}

	@GetMapping("suggest")
	@ResponseBody
	public List<FtSuggestSearchDto> suggest(Model model) {
		List<FtSuggestSearchDto> suggests = ftVideosService.fetchFtSuggestSearchDto();
		return suggests;
	}
}