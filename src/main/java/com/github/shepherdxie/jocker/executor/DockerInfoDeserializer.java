package com.github.shepherdxie.jocker.executor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.shepherdxie.jocker.DockerInfo;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author Shepherd Xie
 * @since 2024/1/30
 */
public class DockerInfoDeserializer extends StdDeserializer<DockerInfo> {
    protected DockerInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DockerInfo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);
        return null;
    }
}
