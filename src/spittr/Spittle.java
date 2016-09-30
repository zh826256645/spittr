package spittr;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author 钟浩
 *
 */
public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public Spittle(Long id, String message, Date time) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
	}

	public Spittle(String message, Date time) {
		this(message, time, null, null);
	}

	public Spittle(String message, Date time, Double latitude, Double longitude) {
		super();
		this.id = null;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Date getTime() {
		return time;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	// 重写 equals 方法
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(obj, obj, "id", "time");
	}
	
	// 重写 hashCode
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}
}
