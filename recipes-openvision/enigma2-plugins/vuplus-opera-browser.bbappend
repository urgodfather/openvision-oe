DESCRIPTION = "Opera HbbTV browser"
PRIORITY = "optional"
LICENSE = "CLOSED"
SECTION = "base"

DEPENDS = "mpfr gmp gstreamer1.0"
RREPLACES_${PN} = "vuplus-opera-browser-util"
RCONFLICTS_${PN} = "vuplus-opera-browser-util"
PACKAGES = "${PN}"

SRC_DATE = "20181117_0"
PR = "r2_${SRC_DATE}"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/hypercube-files/master/opera-hbbtv_${SRC_DATE}.tar.gz"

SRC_URI[md5sum] = "c5cb1ee209971d9abaa11a30299cd723"
SRC_URI[sha256sum] = "71f0692bde2b1f001353010102e56a0a92cc02e2bb119944e944ea97d052c3a6"

S = "${WORKDIR}/opera-hbbtv"

do_compile() {
}

do_install() {
	install -d ${D}/usr/local/hbb-browser
	cp -avR ${S}/opera/* ${D}/usr/local/hbb-browser/

	install -d ${D}/usr/lib
	cp -avR ${S}/dfb/usr/lib/* ${D}/usr/lib/
}

do_package_qa() {
}

sysroot_stage_all() {
}

INHIBIT_PACKAGE_STRIP = "1"
PRIVATE_LIBS_${PN} = "libopera_hbbtv.so \
libdsmcc.so \
libdirect-1.4.so.6 \
libdirectfb-1.4.so.6 \
libfusion-1.4.so.6 \
libdirectfbwm_default.so \
libdirectfb_linux_input.so \
libdirectfb_devmem.so \
libdirectfb_dummy.so \
libdirectfb_fbdev.so \
libidirectfbfont_dgiff.so \
libidirectfbvideoprovider_v4l.so \
libidirectfbvideoprovider_gif.so \
libidirectfbimageprovider_dfiff.so \
libidirectfbimageprovider_gif.so \
libidirectfbimageprovider_jpeg.so \
libicoreresourcemanager_test.so \
libdirectfb_vuplus.so"

FILES_${PN} = "/usr/lib /usr/local"