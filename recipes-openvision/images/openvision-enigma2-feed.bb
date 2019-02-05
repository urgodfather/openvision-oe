# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# Trick: We want to create the package index, and we don't actually
# package anything, so we "inherit" the package indexer recipe.
require recipes-core/meta/package-index.bb

# We have a GPLv2 license for this recipe...
require conf/license/openpli-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openvision-enigma2-image"

OPTIONAL_PACKAGES_BROKEN = "samba"
OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""

OPTIONAL_PACKAGES += " \
	astra-sm \
	autofs \
	autossh \
	ccid \
	ctorrent \
	cups \
	davfs2 \
	dhrystone \
	diffutils \
	djmount \
	dosfstools \
	dvblast \
	dvbsnoop \
	dvdfs \
	edid-decode \
	evtest \
	exfat-utils \
	exteplayer3 \
	fuse-exfat \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "gdb", d)} \
	grep \
	gstplayer \
	hddtemp \
	hdparm \
	inadyn-mt \
	inetutils \
	iperf3 \
	iproute2 \
	${@bb.utils.contains_any("MACHINE", "dm800", "", "iptraf", d)} \
	iputils \
	joe \
	${@bb.utils.contains_any("MACHINE", "dm800", "", "lirc", d)} \
	less \
	libbluray \
	libudfread \
	mc \
	mediainfo \
	minisatip \
	mtd-utils \
	mtools \
	nano \
	nbench-byte \
	net-tools \
	${@bb.utils.contains("TARGET_FPU", "soft", "", "nodejs", d)} \
	ntfs-3g \
	ntp \
	ofgwrite \
	openmultiboot \
	openresolv \
	openssh \
	openvpn \
	parted \
	picocom \
	ppp \
	procps \
	pv \
	pyload \
	python-beautifulsoup4 \
	python-ipaddress \
	python-js2py \
	python-lxml \
	python-mechanize \
	python-ntplib \
	python-pip \
	python-pyexecjs \
	python-requests \
	rsync \
	rtorrent \
	sabnzbd \
	${@bb.utils.contains_any("MACHINE", "dm800", "", "satipclient", d)} \
	screen \
	sed \
	shellinabox \
	smartmontools \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "smbnetfs", d)} \
	sshfs-fuse \
	sshpass \
	strace \
	tcpdump \
	tmux \
	transmission \
	udpxy \
	upx \
	usb-modeswitch \
	usb-modeswitch-data \
	v4l-utils \
	vim \
	wget \
	wscan \
	yafc \
	zeroconf \
	zip \
	zsh \
	${OPTIONAL_BSP_PACKAGES} \
	"
	
EXTRA_WIFI_DRIVERS += "\
	${@bb.utils.contains_any("MACHINE", "cube dm800 su980", "", "rtl8723a", d)} \
	${@bb.utils.contains("MACHINE_ESSENTIAL_EXTRA_RDEPENDS", "spycat-rtl8723bs", "", "rtl8723bs", d)} \
	${@bb.utils.contains_any("MACHINE", "cube dm500hd dm500hdv2 dm800 dm800se dm800sev2 dm7020hd dm7020hdv2 su980 ixusszero ixussone dm820 dm8000 dm7080 dm520", "", "rtl8812au", d)} \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rtl8814au", d)} \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rtl8822bu", d)} \
	${@bb.utils.contains_any("MACHINE", "et5x00 et6x00 et9x00 vuduo vusolo vuuno vuultimo osmio4k cube dm500hd dm500hdv2 dm800 dm800se dm800sev2 dm7020hd dm7020hdv2 su980 force1 force1plus iqonios100hd iqonios200hd iqonios300hd iqonios300hdv2 mediabox optimussos1 optimussos1plus optimussos2 optimussos2plus optimussos3plus tm2t tmnano2super tmnano2t tmnano3t tmnano tmsingle tmtwin worldvisionf1 worldvisionf1plus azboxhd azboxme azboxminime maram9 k1plus ixusszero ixussone ventonhdx sezam5000hd mbtwin beyonwizt3 gb800ue gb800solo gb800se dm820 dm8000 dm7080 dm520 x8hp wetekhub wetekplay2  wetekplay", "", "rtl8189es", d)} \
	${@bb.utils.contains_any("MACHINE", "osmio4k dm800", "", "rtl8192eu", d)} \
	"

EXTRA_WIFI_DRIVERS_remove_dm800 += " \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	"

EXTRA_WIFI_DRIVERS_remove_su980 += " \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	smbnetfs \
	"

EXTRA_WIFI_DRIVERS_remove_cube += " \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	smbnetfs \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""

ENIGMA2_OPTIONAL += " \
	cdtextinfo \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	${@bb.utils.contains_any("MACHINE_FEATURES", "textlcd colorlcd colorlcd220 colorlcd390 colorlcd400 colorlcd480 colorlcd720 colorlcd800 bwlcd96 bwlcd128 bwlcd140 bwlcd255", "enigma2-display-skins", "", d)} \
	enigma2-pliplugins \
	${@bb.utils.contains("EXTRA_IMAGEDEPENDS", "vuplus-tuner-turbo", "enigma2-plugin-drivers-dvb-usb-turbo", "", d)} \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-automatic-fullbackup \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-blurayplayer \
	enigma2-plugin-extensions-btdevicesmanager \
	${@bb.utils.contains_any("MACHINE_FEATURES", "chromium chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-dreamplex \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-e2iplayer-deps \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-fontinfo \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-install-exteplayer3 \
	enigma2-plugin-extensions-install-ffmpeg \
	enigma2-plugin-extensions-install-gstplayer \
	enigma2-plugin-extensions-lcd4linux \
	enigma2-plugin-extensions-managerautofs \
	enigma2-plugin-extensions-modifyplifullhd \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-refreshbouquet \
	${@bb.utils.contains_any("MACHINE", "cube su980", "", "enigma2-plugin-extensions-sdgradio", d)} \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-extensions-youtube-dl \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-cinogripli \
	enigma2-plugin-skins-dreamplexskins \
	enigma2-plugin-skins-glamouraurafhd \
	enigma2-plugin-skins-kravenfhd \
	enigma2-plugin-skins-kravenhd \
	enigma2-plugin-skins-kravenvb \
	enigma2-plugin-skins-metrix-vision \
	enigma2-plugin-skins-mx-hq7 \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-skins-pd1loi-hd-night \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-sevenhd \
	enigma2-plugin-skins-simple-gray-hd \
	enigma2-plugin-skins-xionhdf \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-systemplugins-bh-skin-support \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-hrtunerproxy \
	${@bb.utils.contains("MACHINE_FEATURES", "micom", "enigma2-plugin-systemplugins-micomupgrade" , "", d)} \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugin-systemplugins-quadpip \
	enigma2-plugins \
	enigma2-skins \
	libcrypto-compat \
	meta-enigma2-dvdburn \
	packagegroup-openplugins \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${@bb.utils.contains("MACHINE_FEATURES", "transcoding", "streamproxy", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "multitranscoding", "streamproxy", "", d)} \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL} ${EXTRA_WIFI_DRIVERS}"	
